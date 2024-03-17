import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentdataService {
  //url will be the domain we get from the aws elastic beanstalk
  //http://<url>/api/students
  studenturl:string='http://localhost:8686/api/students'
  constructor(private httpservice: HttpClient) { }

  GetStudents():Observable<Student>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*' // Allow requests from any origin (replace with specific origin in production)
    });
    return this.httpservice.get<Student>(this.studenturl,{headers})
      .pipe(retry(3), catchError(this.myerrorhandler))
  }
  GetStudentsById(id:string):Observable<Student>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*' // Allow requests from any origin (replace with specific origin in production)
    });
    return this.httpservice.get<Student>(this.studenturl+"/"+id,{headers})
      .pipe(retry(3), catchError(this.myerrorhandler))
  }

  DeleteStudent(id: string | undefined): Observable<void> {
    const url = `${this.studenturl}/${id}`; // Construct the URL for the specific student
    return this.httpservice.delete<void>(url)
      .pipe(
        catchError(this.myerrorhandler) // Handle errors
      );
  }

  UpdateStudent(id: string|undefined, updatedStudentData: any): Observable<void> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*' // Allow requests from any origin (replace with specific origin in production)
    });
    const url = `${this.studenturl}/${id}`;
    return this.httpservice.put<void>(url, updatedStudentData, {headers})
      .pipe(
        catchError(this.myerrorhandler)
      );
  }
  
  private myerrorhandler(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred.. either client side or network:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }
}

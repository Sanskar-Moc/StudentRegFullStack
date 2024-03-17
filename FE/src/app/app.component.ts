import { Component } from '@angular/core';
import { StudentdataService } from './studentdata.service';
import { Student } from './student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'student-app';
  studentsList: any[] | undefined;
  getId=''
  constructor(private studentservice:StudentdataService){}

  ngOnInit(){
    this.loadstudents()
  }
  // Load students
  loadstudents() {
    return this.studentservice.GetStudents().subscribe((data: any) => {
      this.studentsList = data;
    })
  }

  byId(){
    return this.studentservice.GetStudentsById(this.getId).subscribe((data: any) => {
      console.log(data)
      this.studentsList = [data];
      this.getId='';
    })
  }

  editedStudent: Student=new Student();

  editStudent(student: any) {
    // Copy the student object to editedStudent
    this.editedStudent = student;
    // Show the modal
    const modal = document.getElementById('editStudentModal');
    modal?.classList.add('show');
    modal?.setAttribute('aria-modal', 'true');
    modal?.setAttribute('style', 'display: block;');
  }

  updateStudent() {
    return this.studentservice.UpdateStudent(this.editedStudent.id,this.editedStudent).subscribe(() => {
      this.loadstudents()
      this.closeModal();
    })
    
  }

  closeModal() {
    // Reset editedStudent
    this.editedStudent = new Student();
    // Hide the modal
    const modal = document.getElementById('editStudentModal');
    modal?.classList.remove('show');
    modal?.setAttribute('aria-modal', 'false');
    modal?.setAttribute('style', 'display: none;');
  }
  deleteStudent(student:Student){
    return this.studentservice.DeleteStudent(student.id).subscribe(() => {
      this.loadstudents()
    })
  }
}

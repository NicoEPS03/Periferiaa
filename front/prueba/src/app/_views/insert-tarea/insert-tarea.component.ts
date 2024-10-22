import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { TareaService } from '../../_service/tarea.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { Tarea } from '../../_model/Tarea';

@Component({
  selector: 'app-insert-tarea',
  templateUrl: './insert-tarea.component.html',
  styleUrl: './insert-tarea.component.css'
})
export class InsertTareaComponent implements OnInit{
  form!: FormGroup;
  id!: number;

  constructor(private tareaService: TareaService, public dialogRef: MatDialogRef<InsertTareaComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private infoSnackBar: MatSnackBarModule) { }

  ngOnInit() {
    this.inicializarFormularioVacio();
  }
  
  inicializarFormularioVacio(){  
      this.form = new FormGroup({
        'id': new FormControl(0, [Validators.required]),
        'titulo': new FormControl('', [Validators.required]),
        'descripcion': new FormControl('', [Validators.required]),
      });
  }

  guardar() {
    let tarea = new Tarea();
    tarea.titulo = this.form.value['titulo'];
    tarea.descripcion = this.form.value['descripcion'];

      this.tareaService.guardar(tarea).subscribe(() => {
        this.form.reset();
        this.dialogRef.close();
        this.tareaService.mensajeCambio.next('Tarea agregada satisfactoreamente');
      });
  }
}

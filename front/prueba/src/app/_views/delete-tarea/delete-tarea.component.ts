import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { TareaService } from '../../_service/tarea.service';

@Component({
  selector: 'app-delete-tarea',
  templateUrl: './delete-tarea.component.html',
  styleUrl: './delete-tarea.component.css'
})
export class DeleteTareaComponent {
  constructor(public dialogRef: MatDialogRef<DeleteTareaComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private tareaService: TareaService,) { }

  ngOnInit(): void {
  }

  eliminar() {
    this.tareaService.eliminar(this.data.id).subscribe(data => {
      this.dialogRef.close();
      this.tareaService.mensajeCambio.next('Tarea eliminada satisfactoreamente ');
    });
  }
}

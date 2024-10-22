import { Component } from '@angular/core';
import { TareaService } from '../../_service/tarea.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DeleteTareaComponent } from '../delete-tarea/delete-tarea.component';
import { InsertTareaComponent } from '../insert-tarea/insert-tarea.component';

@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrl: './tarea.component.css'
})
export class TareaComponent {
  displayedColumns: string[] = ['id', 'titulo', 'descripcion', 'accion'];
  dataSource = new MatTableDataSource<any>();

  constructor(private clienteService: TareaService, private dialog: MatDialog, private snackBar: MatSnackBar){};

  ngOnInit(): void {
    this.listar();
  }

  listar(){
    this.clienteService.listar().subscribe(data =>{
      this.dataSource = new MatTableDataSource(data);
    });
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, 'Información', {
      duration: 2000,
    });
  }

  insertModal(){
    const dialogRef = this.dialog.open(InsertTareaComponent, { data: { edit: false} });
    this.clienteService.mensajeCambio.subscribe(data => {
      dialogRef.afterClosed().subscribe(result => {
        this.listar();
        this.openSnackBar(data);
      });
    });
  }

  deleteModal(id: any){
    const dialogRef = this.dialog.open(DeleteTareaComponent, { data: {id: id} });
    this.clienteService.mensajeCambio.subscribe(data => {
      dialogRef.afterClosed().subscribe(result => {
        this.listar();
        this.openSnackBar(data);
      });
    });
  }
}

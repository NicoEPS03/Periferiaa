import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertTareaComponent } from './insert-tarea.component';

describe('InsertTareaComponent', () => {
  let component: InsertTareaComponent;
  let fixture: ComponentFixture<InsertTareaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InsertTareaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InsertTareaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

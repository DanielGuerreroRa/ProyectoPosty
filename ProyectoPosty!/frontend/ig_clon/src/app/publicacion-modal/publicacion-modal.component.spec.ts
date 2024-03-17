

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicacionModalComponent } from './publicacion-modal.component';

describe('PublicacionModalComponent', () => {
  let component: PublicacionModalComponent;
  let fixture: ComponentFixture<PublicacionModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PublicacionModalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PublicacionModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AngazovaniPredmetiComponent } from './angazovani-predmeti.component';

describe('AngazovaniPredmetiComponent', () => {
  let component: AngazovaniPredmetiComponent;
  let fixture: ComponentFixture<AngazovaniPredmetiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AngazovaniPredmetiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AngazovaniPredmetiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SsBibliotekaComponent } from './ss-biblioteka.component';

describe('SsBibliotekaComponent', () => {
  let component: SsBibliotekaComponent;
  let fixture: ComponentFixture<SsBibliotekaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SsBibliotekaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SsBibliotekaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

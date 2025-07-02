import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PredmetnaObavestenjaComponent } from './predmetna-obavestenja.component';

describe('PredmetnaObavestenjaComponent', () => {
  let component: PredmetnaObavestenjaComponent;
  let fixture: ComponentFixture<PredmetnaObavestenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PredmetnaObavestenjaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PredmetnaObavestenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

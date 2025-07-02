import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GlobalnaObavestenjaComponent } from './globalna-obavestenja.component';

describe('GlobalnaObavestenjaComponent', () => {
  let component: GlobalnaObavestenjaComponent;
  let fixture: ComponentFixture<GlobalnaObavestenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GlobalnaObavestenjaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GlobalnaObavestenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

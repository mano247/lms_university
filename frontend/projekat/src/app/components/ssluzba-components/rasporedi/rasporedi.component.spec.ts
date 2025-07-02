import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RasporediComponent } from './rasporedi.component';

describe('RasporediComponent', () => {
  let component: RasporediComponent;
  let fixture: ComponentFixture<RasporediComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RasporediComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RasporediComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

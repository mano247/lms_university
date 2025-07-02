import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObavestenjaProfComponent } from './obavestenja-prof.component';

describe('ObavestenjaProfComponent', () => {
  let component: ObavestenjaProfComponent;
  let fixture: ComponentFixture<ObavestenjaProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ObavestenjaProfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ObavestenjaProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

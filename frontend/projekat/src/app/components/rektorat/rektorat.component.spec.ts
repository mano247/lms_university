import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RektoratComponent } from './rektorat.component';

describe('RektoratComponent', () => {
  let component: RektoratComponent;
  let fixture: ComponentFixture<RektoratComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RektoratComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RektoratComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

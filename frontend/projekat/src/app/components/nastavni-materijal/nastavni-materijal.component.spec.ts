import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NastavniMaterijalComponent } from './nastavni-materijal.component';

describe('NastavniMaterijalComponent', () => {
  let component: NastavniMaterijalComponent;
  let fixture: ComponentFixture<NastavniMaterijalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NastavniMaterijalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NastavniMaterijalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

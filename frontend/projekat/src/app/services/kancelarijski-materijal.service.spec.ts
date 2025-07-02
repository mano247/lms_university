import { TestBed } from '@angular/core/testing';

import { KancelarijskiMaterijalService } from './kancelarijski-materijal.service';

describe('KancelarijskiMaterijalService', () => {
  let service: KancelarijskiMaterijalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KancelarijskiMaterijalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

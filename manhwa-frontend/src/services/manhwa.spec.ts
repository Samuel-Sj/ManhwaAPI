import { TestBed } from '@angular/core/testing';

import { Manhwa } from './manhwa';

describe('Manhwa', () => {
  let service: Manhwa;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Manhwa);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

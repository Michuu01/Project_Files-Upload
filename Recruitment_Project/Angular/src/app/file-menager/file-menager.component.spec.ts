import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FileMenagerComponent } from './file-menager.component';

describe('FileMenagerComponent', () => {
  let component: FileMenagerComponent;
  let fixture: ComponentFixture<FileMenagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FileMenagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FileMenagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

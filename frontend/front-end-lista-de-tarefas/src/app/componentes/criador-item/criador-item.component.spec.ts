import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriadorItemComponent } from './criador-item.component';

describe('CriadorItemComponent', () => {
  let component: CriadorItemComponent;
  let fixture: ComponentFixture<CriadorItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriadorItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriadorItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

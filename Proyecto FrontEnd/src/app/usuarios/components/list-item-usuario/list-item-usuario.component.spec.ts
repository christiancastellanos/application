import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListItemUsuarioComponent } from './list-item-usuario.component';

describe('ListItemUsuarioComponent', () => {
  let component: ListItemUsuarioComponent;
  let fixture: ComponentFixture<ListItemUsuarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListItemUsuarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListItemUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

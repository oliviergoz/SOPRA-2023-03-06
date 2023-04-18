import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ServiceExempleService {
  constructor() {
    console.debug('creation service');
  }

  public sayHello(): string {
    return 'hello world';
  }
}

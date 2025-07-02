import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private loginService: LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.loginService.getToken(); 
    if (token) {
      const authReq = req.clone({
        setHeaders: {
          "Authorization": `Bearer ${token}`
        }
      });
      return next.handle(authReq);
    } else {
      return next.handle(req);
    }
  }
  //   if(this.loginService.getToken()){
  //     let newReq = req.clone({headers: req.headers.set("Authorization", this.loginService.getToken())});
  //     return next.handle(newReq);
  //   }
  //   return next.handle(req);
  // }
}

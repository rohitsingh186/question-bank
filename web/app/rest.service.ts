import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class RestService {

    constructor(private http: Http) {}

    getBoard(): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.get('http://localhost:8085/board')
                .toPromise()
                .then((data) => {
                    resolve(data.json());
                })
                .catch((error) => {
                    reject(error);
                });
        });
    }

    play(column): Promise<any> {
        let body = {
            playedColumn: column
        };

        return new Promise((resolve, reject) => {
            this.http.post('http://localhost:8085/play', body)
                .toPromise()
                .then((data) => {
                    resolve(data.json());
                })
                .catch((error) => {
                    reject(error);
                });
        });
    }

    initialize(): Promise<any> {
        return new Promise((resolve, reject) => {
            this.http.get('http://localhost:8085/initialize')
                .toPromise()
                .then((data) => {
                    resolve(data.json());
                })
                .catch((error) => {
                    reject(error);
                });
        });
    }
}
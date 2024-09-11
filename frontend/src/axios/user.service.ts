import http from "../axios/http-common.ts";
import IUserLogData from "../axios/user.type.ts";
import IUserRegData from "../axios/user.type.ts";

class UserDataService {
    auth(data: IUserLogData) {
        return http.post("/auth", data);
    }
    reg(data: IUserRegData) {
        return http.post("/registration", data);
    }
    test(data: any, JWTToken: string) {
        return http.post("/auth", data,
            { headers: {"Authorization" : `Bearer ${JWTToken}`} });
    }

 /*   get(id: string) {
        return http.get<IUserData>(`/tutorials/${id}`);
    }



    update(data: IUserData, id: any) {
        return http.put<any>(`/tutorials/${id}`, data);
    }

    delete(id: any) {
        return http.delete<any>(`/tutorials/${id}`);
    }

    deleteAll() {
        return http.delete<any>(`/tutorials`);
    }

    findByTitle(title: string) {
        return http.get<Array<IUserData>>(`/tutorials?title=${title}`);
    }*/
}

export default new UserDataService();
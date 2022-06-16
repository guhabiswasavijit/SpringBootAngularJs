export class User {
    id: string;
    name: string;
    email: string;
    constructor(t_id:string,t_name:string,t_email:string){
        this.id = t_id;
        this.name = t_name;
        this.email = t_email;
    }
}

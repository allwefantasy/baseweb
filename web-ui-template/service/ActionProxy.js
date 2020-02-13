import {Backend,Method} from '@allwefantasy/web-platform-ui'
import RemoteAction from './RemoteAction'
export class ActionProxy {
    constructor(){
        this.backend = new Backend()        
    }
    request=(action,params,success,fail)=>{
        this.backend.request(action,Method.POST,params,success,fail) 
    } 
    
    hello = (success,fail)=>{        
       this.backend.request(RemoteAction.HELLO,Method.GET,{},success,fail)
    }
}
export class UserActionParams {
   static USERE_NAME = "userName"   
   
}
export class ResponseKey {
    static SIGH_IN_MAIN_PAGE = "sighInMainPage"
}
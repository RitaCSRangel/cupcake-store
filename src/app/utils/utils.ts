export function checkLogin(){

    try{
      const loggedUser = sessionStorage.getItem('user');
      if (loggedUser){
        return true;
      }else{
        return false
      }
    }catch(e){
      console.log(e);
      return false;
    }

}
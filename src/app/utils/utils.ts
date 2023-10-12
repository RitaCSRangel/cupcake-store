import { User } from "../services/users/user-model";

export function checkLogin() {

  try {
    const loggedUser: User = JSON.parse(sessionStorage.getItem('user') || '{}');
    if (loggedUser.id != null) {
      return true;
    } else {
      return false
    }
  } catch (e) {
    console.log(e);
    return false;
  }

}

export function getCart() {
  let sessionCart = JSON.parse(sessionStorage.getItem('cart') || '{}')
  if (sessionCart.length > 0) {
    return sessionCart;
  } else {
    return null;
  }
}

export function setCart(products: any){
    sessionStorage.setItem('cart', JSON.stringify(products));
}

export function getUser() {
  let user = JSON.parse(sessionStorage.getItem('user') || '{}')
  if (user) {
    return user;
  } else {
    return null;
  }
}

export function setUser(user: any){
    sessionStorage.setItem('user', JSON.stringify(user));
}
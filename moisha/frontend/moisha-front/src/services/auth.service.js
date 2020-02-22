import axios from 'axios'

const AUTH_URL = 'api/users/auth/'

class AuthService {
  login (user) {
    return axios
      .post(AUTH_URL + 'signIn', {
        userEmail: user.email,
        userPassword: user.password
      })
      .then(response => {
        if (response.data.token) {
          localStorage.setItem('user', JSON.stringify(response.data))
        }
        return response.data
      })
  }

  logout () {
    localStorage.removeItem('user')
  }

  register (user) {
    return axios.post(AUTH_URL + 'signUp', {
      username: user.username,
      email: user.email,
      password: user.password
    })
  }
}

export default new AuthService()

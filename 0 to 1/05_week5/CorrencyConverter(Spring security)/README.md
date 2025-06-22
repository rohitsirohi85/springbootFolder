steps to insert spring security in your application with jwt based authentication

1. insert spring security dependency  & implement userDetails interface in main User entity
2. implement the UserDetailService where you make the service of user entity
3. make webSecurity configuration to prevent security breaches
4. implement 3 jwt based dependencies
5. make the jwtService to generate and verify token and get user id from token
6. configure the authentication manager and use that in login endpoint but make sure when u signup the user it is mandatory to use password encoder otherwise it will throw error coz authentication manager default use the password encoder to authenticate the user
7. make JwtAuthFilter so we can verify the request from token
8. add jwt filter before UsernamePasswordAuthFilter



steps to make a logic so user can only able to login through one device by using and saving session in DB not in browser and inside that DB i will store user id with token and if user try to login in new device the previous session will be deleted
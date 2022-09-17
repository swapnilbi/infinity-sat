
export const AppConfig = {
  SERVICE_URL : {
    AUTHENTICATE_URL : 'api/authenticate',
    REFRESH_TOKEN_URL : 'api/authenticate/refresh',
    LOGOUT_URL : 'api/logout',
    GET_USER_PROFILE_URL : '/api/employee/profile',
    INIT_SPACE_ALLOTMENT : '/api/space/allotment/init',
    CREATE_ALLOTMENT : '/api/space/allotment',
    GET_ALLOTMENTS_URL : '/api/space/allotments',
    GET_SPACE_CAPACITY_URL : '/api/space/capacity',
    GET_ALLOTMENTS_BY_ZONE_URL : '/api/space/allotment/zone/:zoneId'    
  }

}

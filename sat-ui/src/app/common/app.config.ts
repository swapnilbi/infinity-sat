
export const AppConfig = {
  SERVICE_URL : {
    AUTHENTICATE_URL : 'api/authenticate',
    REFRESH_TOKEN_URL : 'api/authenticate/refresh',
    LOGOUT_URL : 'api/logout',
    GET_USER_PROFILE_URL : '/api/employee/profile',
    INIT_SPACE_ALLOTMENT : '/api/space/allotment/init',
    CREATE_ALLOTMENT : '/api/space/allotment',
    SPLIT_ALLOTMENT : '/api/space/allotment/split',
    GET_ALLOTMENTS_URL : '/api/space/allotments',
    GET_MANAGER_ALLOTMENTS_URL : '/api/space/allotment/manager',
    GET_SPLITTED_ALLOTMENTS_URL : '/api/space/allotment/splits',    
    GET_SPACE_CAPACITY_URL : '/api/space/capacity',
    GET_ALLOTMENTS_BY_ZONE_URL : '/api/space/allotment/zone/:zoneId',
    GET_MANAGER_SUB_DIVISION_LIST : '/api/admin/oe-structures/childrens',
    INIT_RESERVATION : '/api/reservation/init',
    SEARCH_SEATS : '/api/reservation/search',
    BOOK_SEAT: '/api/reservation/book',
    GET_NEXT_SLOTS: '/api/reservation/book/nextSlots'
  }

}

export const BASE_URL = 'http://localhost:8080/api/v1';

export const PLAYER = '/player';
export const MATCH = '/match';
export const HERO = '/hero';
export const ID = '/$id$';

export const ALL = '/all';
export const SLASH = '/';

export const HERO_URL =  BASE_URL + HERO;
export const HERO_BY_ID_URL =  HERO_URL + ID;
export const ALL_HEROES_URL =  BASE_URL + HERO + ALL;

export const MATCH_URL = BASE_URL + MATCH;
export const MATCH_BY_ID_URL = MATCH_URL + ID;
export const ALL_MATCH_PLAYERS_BY_MATCH_ID_URL = MATCH_URL + '/players' + MATCH + ID;
export const ALL_MATCH_HEROES_BY_MATCH_ID_URL = MATCH_URL + '/heroes' + MATCH;
export const MATCH_WINNER_BY_MATCH_ID_URL = MATCH_URL + '/winner' + MATCH;

export const PLAYER_URL = BASE_URL + '/player';
export const LAST_PLAYER_MATCH_BY_STEAM_ID_URL = PLAYER_URL + ID;
export const FIXED_NUMBER_PLAYER_MATCHES = PLAYER_URL + ID + '/matches';

export const PATH_TO_MAIN_PAGE = '/';
export const PATH_TO_MATCHES_PAGE = '/matches'

export const STEAM_ID = 76561198087981013;
export const HEROES = 'heroes';
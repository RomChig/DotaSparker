export const BASE_URL = 'http://localhost:8080/api/v1';

export const PLAYERS = '/players';
export const MATCHES = '/matches';
export const HEROES = '/heroes';
export const ID = '/$id$';

export const SLASH = '/';

export const HERO_URL =  BASE_URL + HEROES;
export const HERO_BY_ID_URL =  HERO_URL + ID;
export const ALL_HEROES_URL =  HERO_URL;

export const MATCH_URL = BASE_URL + MATCHES;
export const MATCH_BY_ID_URL = MATCH_URL + ID;
export const ALL_MATCH_PLAYERS_BY_MATCH_ID_URL = MATCH_URL + PLAYERS + MATCHES + ID;
export const ALL_MATCH_HEROES_BY_MATCH_ID_URL = MATCH_URL + HEROES + MATCHES;
export const MATCH_WINNER_BY_MATCH_ID_URL = MATCH_URL + '/winner' + MATCHES;

export const PLAYER_URL = BASE_URL + PLAYERS;
export const LAST_PLAYER_MATCH_BY_STEAM_ID_URL = PLAYER_URL + ID;
export const FIXED_NUMBER_PLAYER_MATCHES = PLAYER_URL + ID + MATCHES;

export const PATH_TO_MAIN_PAGE = '/';
export const PATH_TO_MATCHES_PAGE = MATCHES;

export const STEAM_ID = 76561198087981013;
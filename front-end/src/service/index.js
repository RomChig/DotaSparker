import {getHeroById, getAllHeroes} from './HeroService';
import {loadHeroes} from './HeroesLoadService';
import {replaceIdInTheString, axiosHandler} from './ServiceUtil'
import {
    saveToLocalStorage,
    loadFromLocalStorage,
    isEmptyStorage
} from './CustomLocalStorageService';
import {
    getAllMatchPlayersById,
    getMatchById,
    getAllMatchHeroesById,
    getMatchWinnerById
} from "./MatchService";

export {
    getHeroById,
    getAllHeroes,
    saveToLocalStorage,
    loadFromLocalStorage,
    isEmptyStorage,
    loadHeroes,
    getAllMatchPlayersById,
    getMatchById,
    getAllMatchHeroesById,
    getMatchWinnerById,
    replaceIdInTheString,
    axiosHandler
}
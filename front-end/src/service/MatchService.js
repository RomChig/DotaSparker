import axios from "axios";
import {
    ALL_MATCH_HEROES_BY_MATCH_ID_URL,
    ALL_MATCH_PLAYERS_BY_MATCH_ID_URL,
    MATCH_BY_ID_URL,
    MATCH_WINNER_BY_MATCH_ID_URL
} from "../util";
import {replaceIdInTheString, axiosHandler} from "./";

export const getMatchById = async matchId => {
    return await axiosHandler(
        axios.get(replaceIdInTheString(MATCH_BY_ID_URL, matchId))
    );
}

export const getAllMatchPlayersById = async matchId => {
    return await axiosHandler(
        axios.get(replaceIdInTheString(ALL_MATCH_PLAYERS_BY_MATCH_ID_URL, matchId))
    );
}

export const getAllMatchHeroesById = async matchId => {
    return await axiosHandler(
        axios.get(replaceIdInTheString(ALL_MATCH_HEROES_BY_MATCH_ID_URL, matchId))
    );
}

export const getMatchWinnerById = async matchId => {
    return await axiosHandler(
        axios.get(replaceIdInTheString(MATCH_WINNER_BY_MATCH_ID_URL, matchId))
    );
}
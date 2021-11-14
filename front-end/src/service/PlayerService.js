import axios from "axios";
import {FIXED_NUMBER_PLAYER_MATCHES, LAST_PLAYER_MATCH_BY_STEAM_ID_URL} from "../util";
import {axiosHandler, replaceIdInTheString} from "./";


export const getAmountPlayerMatches = async (steamId, matchNumbers) => {
    const config = {
        params: {
            amount: matchNumbers < 100 ? matchNumbers : 100
        }
    };
    return await axiosHandler(
        axios.get(replaceIdInTheString(FIXED_NUMBER_PLAYER_MATCHES, steamId), config)
    );
}

export const getLastMatch = async steamId => {
    return await axiosHandler(
        axios.get(replaceIdInTheString(LAST_PLAYER_MATCH_BY_STEAM_ID_URL, steamId))
    );
}
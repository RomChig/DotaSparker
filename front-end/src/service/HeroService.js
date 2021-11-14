import axios from "axios";
import {ALL, HERO_URL} from "../util";
import {axiosHandler} from "./";

export const getHeroById = async id => await axiosHandler(axios.get(HERO_URL.concat(id)));

export const getAllHeroes = async () => await axiosHandler(axios.get(HERO_URL.concat(ALL)));

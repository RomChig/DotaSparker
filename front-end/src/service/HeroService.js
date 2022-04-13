import axios from "axios";
import {HERO_URL} from "../util";
import {axiosHandler} from "./";

export const getHeroById = async id => await axiosHandler(axios.get(HERO_URL.concat(id)));

export const getAllHeroes = async () => await axiosHandler(axios.get(HERO_URL));

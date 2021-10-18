import {secondsToMinutesConverter} from "../util";
import {ImageWrapper} from "../component";

export const MatchDetail = ({match}) => {
    return (
        <tbody>
        <tr>
            <td>{match.matchId}</td>
            <td>{match.gameMode}</td>
            <td>{match.side}</td>
            <td>{secondsToMinutesConverter(match.duration)}</td>
            <td>{match.playerList.map((player, index) =>
                <th key={index}>
                    <td>
                        <div>
                            <ImageWrapper imagePath={`dota_images/heroes/id_${player.heroDTO.id}.png`}/>
                        </div>
                    </td>
                </th>
            )}</td>
        </tr>
        </tbody>
    )
}
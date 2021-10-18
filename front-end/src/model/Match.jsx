import {ImageWrapper} from "../component";

export const Match = ({match, onClick = f => f}) => {
    return (
        <tbody onClick={() => onClick(match.matchId)}>
        <tr>
            <td>{match.matchId}</td>
            <td>{match.startTime}</td>
            <td>{match.players.map((player, index) =>
                <th key={index}>
                    <td>
                        <div>
                          <ImageWrapper imagePath={`dota_images/heroes/id_${player.hero_id}.png`}/>
                        </div>
                    </td>
                </th>
            )}</td>
        </tr>
        </tbody>
    )
}
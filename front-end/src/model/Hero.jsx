import {ImageWrapper} from "../component";

export const Hero = ({hero}) => {
    return (
        <tbody>
        <tr>
            <th>{hero.id}</th>
            <th>
                <div>
                    <ImageWrapper className={'p-0'}
                                  //TODO in accordance with adding a new heroes, should know that we need to upload a new image.
                                  imagePath={`dota_images/heroes/id_${hero.id}.png`}
                                  width={'125.78'}
                                  height={'63'}/>
                </div>
            </th>
            <th>{hero.localizedName}</th>
            <th>{hero.name}</th>
        </tr>
        </tbody>
    )
}
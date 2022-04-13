import {Image} from "react-bootstrap";

export const ImageWrapper = (
    {
        imagePath,
        width = '80',
        height = '50',
        className = 'p-1'
    }
) => {
    return (
        <Image className={className}
               src={imagePath}
               width={width}
               height={height}
        />
    )
}
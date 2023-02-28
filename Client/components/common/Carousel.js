import { fetchImages } from "./api/index";
import "./ImageCarousle.scss";
import Slider from "react-slick";
import { Carousel } from "react-bootstrap";

const ImageCarousle = (props) => {
  const [photos, setPhotos] = useState([]);
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1
  };

  fetchImages().then((data) => {
    setPhotos(data);
  });
  return (
    <Carousel>
      {photos.map((imageUrl, i) => {
        return (
          <Carousel.Item>
            <img src={imageUrl} alt="123" />
          </Carousel.Item>
        );
      })}
    </Carousel>
    // <ListItem />
  );
};
export default ImageCarousle;

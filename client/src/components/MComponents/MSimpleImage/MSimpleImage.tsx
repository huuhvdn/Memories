import Image from "next/image";

interface MSimpleImageProps {
  imageUrl: string;
}
const MSimpleImage: React.FC<MSimpleImageProps> = ({
  imageUrl = "",
}: MSimpleImageProps) => {
  return (
    <img
      src={imageUrl}
      alt="Picture of the author"
      className="tw-w-full tw-h-full tw-bg-cover tw-rounded"
    />
  );
};

export default MSimpleImage;

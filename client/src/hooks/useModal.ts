import { useState } from "react"

export default function useModal() {
    const [show, setShow] = useState<boolean>(false);

    const open = () => {
        setShow(true);
    }

    const onClose = () => {
        setShow(false);
    }

    return {
        show, open, onClose
    }
}
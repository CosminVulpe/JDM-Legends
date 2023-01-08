import React, {useState} from "react";
import {
    Button,
    ModalBody,
    ModalCloseButton,
    ModalContent,
    ModalHeader,
    useDisclosure,
    ModalOverlay,
    ModalFooter,
    Text,
    Modal,
    NumberInput,
    NumberInputField,
    NumberInputStepper,
    NumberIncrementStepper,
    NumberDecrementStepper
} from "@chakra-ui/react";
import {ApiPostCar} from "../Service/api-requests/ApiRequests";
import {HistoryBid} from "../Service/interfaces/Interfaces";
import {successfulNotification} from "../Service/toastify-notification/ToastifyNotification";
import {ToastContainer} from "react-toastify";
import {useAtom} from "jotai";
import {HISTORY_BID_DETAILS} from "../jotai-atom/JotaiAtom";

interface Props {
    id: number
}

const PopUp: React.FC<Props> = ({id}) => {
    const {isOpen, onOpen, onClose} = useDisclosure();
    const [historyBid, setHistoryBid] = useState<HistoryBid>({
        bidValue: 0,
        timeOfTheBid: new Date()
    });

    const formatBidValue = (val: number): string => `$` + val;

    const parseValue = (val: string): number => {
        return parseInt(val.replace(/^\$/, ""));
    }

    const handleOnClick = (): void => {
        onClose();
        setHistoryBid(prevState => ({
            ...prevState,
            timeOfTheBid: new Date()
        }));

        ApiPostCar("bid/" + id, historyBid)
            .then(() => successfulNotification("Bid placed successfully"))
            .catch(err => console.error(err));
    }

    const handleOnChange = (valueStr: string): void => {
        setHistoryBid(prevState => ({
            ...prevState,
            bidValue: parseValue(valueStr)
        }));
    }

    return (
        <>
            <ToastContainer/>
            <Button onClick={onOpen}
                    colorScheme="teal">Bid Now</Button>
            <Modal blockScrollOnMount={false}
                   isOpen={isOpen}
                   onClose={onClose}
                   isCentered={true}>
                <ModalOverlay/>
                <ModalContent>
                    <ModalHeader>Bid Total Sum</ModalHeader>
                    <ModalCloseButton/>
                    <ModalBody>
                        <Text fontWeight='bold' mb='1rem'>
                            Choose amount 💸
                            <NumberInput
                                onChange={handleOnChange}
                                value={formatBidValue(historyBid.bidValue)}
                                min={0}
                                keepWithinRange={false}
                                clampValueOnBlur={false}
                                // max={50}
                            >
                                <NumberInputField/>
                                <NumberInputStepper>
                                    <NumberIncrementStepper/>
                                    <NumberDecrementStepper/>
                                </NumberInputStepper>
                            </NumberInput>
                        </Text>
                    </ModalBody>

                    <ModalFooter>
                        <Button colorScheme='teal'
                                mr={3}
                                onClick={handleOnClick}
                        >
                            Submit
                        </Button>
                        <Button variant='solid'
                                onClick={onClose}>
                            Close
                        </Button>
                    </ModalFooter>
                </ModalContent>
            </Modal>
        </>
    )
}

export default PopUp;
'use client';

import { Button, Modal } from 'flowbite-react';
import { useRouter } from 'next/navigation';
import Router from 'next/router';
import { useState } from 'react';
import { HiOutlineExclamationCircle } from 'react-icons/hi';

function ConfirmationModal() {
  const [openModal, setOpenModal] = useState(true);
  const router = useRouter();

  const handleClose = () => {
    setOpenModal(false); 
    router.push('/client/search');
  }

  return (
    <>
      <Modal show={openModal} size="md" onClose={handleClose} popup>
        <Modal.Header />
        <Modal.Body>
          <div className="text-center">
            <HiOutlineExclamationCircle className="mx-auto mb-4 h-14 w-14 text-gray-400 dark:text-gray-200" />
            <h3 className="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">
              no client has been selected to create this offer. Please select a client first through Client Search!
            </h3>
            <div className="flex justify-center gap-4">
              <Button color="failure" onClick={handleClose}>
                Go to Client Search
              </Button>
            </div>
          </div>
        </Modal.Body>
      </Modal>
    </>
  );
}

export default ConfirmationModal;
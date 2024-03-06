'use client';

import { Button, Modal } from 'flowbite-react';

function EditDataModal({ openModal, setOpenModal, handleDataUpdate, tableCols, tableData, handleEditOnChange, editTableData }) {
    console.log("EditDataModal", editTableData, tableCols);
    return (
        <>
            <Modal show={openModal} size="md" popup onClose={() => setOpenModal(false)}>
                <Modal.Header />
                <Modal.Body>
                    <form class="p-4 md:p-5">
                        <div class="grid gap-4 mb-4 grid-cols-2">
                            {editTableData && tableCols && tableCols.map((tCols, key) => {
                                if (tCols?.toLowerCase().includes('description')) return (
                                    <div class="col-span-2">
                                        <label for={tCols} class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">{tCols?.toUpperCase()}</label>
                                        <textarea name={tCols} id={tCols} rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-white rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder={`Write ${tCols} here`} value={editTableData[tCols]} onChange={handleEditOnChange} ></textarea>
                                    </div>
                                )
                                else return (
                                    <div class="col-span-2">
                                        <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">{tCols?.toUpperCase()}</label>
                                        <input type="text" name={tCols} id={tCols} disabled={key == 0} class={`${key == 0 ? 'bg-gray-200' : 'bg-white'} border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500`} value={editTableData[tCols]} placeholder={`Enter ${tCols} here`} onChange={handleEditOnChange} />
                                    </div>)
                            })}
                        </div>
                        <div className="flex justify-center gap-4">
                            <Button color="blue" type='submit' onClick={handleDataUpdate}>
                                Update
                            </Button>
                            <Button color='failure' onClick={() => setOpenModal(false)}>
                                cancel
                            </Button>
                        </div>
                    </form>
                </Modal.Body>
            </Modal>
        </>
    );
}
export default EditDataModal;
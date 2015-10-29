/*
 * Copyright (c) 2015 Fraunhofer FOKUS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openbaton.nfvo.core.interfaces;

import org.openbaton.catalogue.mano.descriptor.NetworkServiceDescriptor;
import org.openbaton.catalogue.mano.descriptor.VNFComponent;
import org.openbaton.catalogue.mano.record.NetworkServiceRecord;
import org.openbaton.catalogue.mano.record.VirtualNetworkFunctionRecord;
import org.openbaton.exceptions.*;
import org.openbaton.vim.drivers.exceptions.VimDriverException;

import java.util.concurrent.ExecutionException;

/**
 * Created by mpa on 30/04/15.
 */

public interface NetworkServiceRecordManagement {

    /**
     * This operation allows submitting and
     * validating a Network Service	Descriptor (NSD),
     * including any related VNFFGD and VLD.
     */
    NetworkServiceRecord onboard(String nsd_id) throws InterruptedException, ExecutionException, VimException, NotFoundException, BadFormatException, VimDriverException, QuotaExceededException;

    /**
     * This operation allows submitting and
     * validating a Network Service	Descriptor (NSD),
     * including any related VNFFGD and VLD.
     */
    NetworkServiceRecord onboard(NetworkServiceDescriptor networkServiceDescriptor) throws ExecutionException, InterruptedException, VimException, NotFoundException, NotFoundException, BadFormatException, VimDriverException, QuotaExceededException;

    /**
     * This operation allows updating a Network
     * Service Descriptor (NSD), including any
     * related VNFFGD and VLD.This update might
     * include creating/deleting new VNFFGDs
     * and/or new VLDs.
     *
     * @param new_nsd
     * @param old_id
     */
    NetworkServiceRecord update(NetworkServiceRecord new_nsd, String old_id);

    /**
     * This operation is used to query the
     * information of the Network Service
     * Descriptor (NSD), including any
     * related VNFFGD and VLD.
     */
    Iterable<NetworkServiceRecord> query();

    NetworkServiceRecord query(String id);

    /**
     * This operation is used to remove a
     * disabled Network Service Descriptor.
     *
     * @param id
     */
    void delete(String id) throws VimException, NotFoundException, ExecutionException, InterruptedException, WrongStatusException;

    void deleteVNFRecord(String idNsr, String idVnf);

    /**
     * Returns the VirtualNetworkFunctionRecord with idVnf into NSR with idNsr
     *
     * @param idNsr of Nsr
     * @param idVnf of VirtualNetworkFunctionRecord
     * @return VirtualNetworkFunctionRecord selected
     */
    VirtualNetworkFunctionRecord getVirtualNetworkFunctionRecord(String idNsr, String idVnf);

    /**
     * Deletes the VNFDependency with idVnfr into NSR with idNsr
     *
     * @param idNsr  of NSR
     * @param idVnfd of VNFDependency
     */
    void deleteVNFDependency(String idNsr, String idVnfd);

    /**
     * This method will add a {@Link VNFCInstance} into a NetworkServiceRecord to a specific VirtualDeploymentUnit of a specific VirtualNetworkFunctionRecord
     *
     * @param id of the NetworkServiceRecord
     * @param idVnf of the VirtualNetworkFunctionRecord
     * @param idVdu of the VirtualDeploymentUnit chosen
     * @param component
     * @return the new VNFCInstance
     */
    void addVNFCInstance(String id, String idVnf, String idVdu, VNFComponent component) throws NotFoundException, BadFormatException, WrongStatusException;

    /**
     * This method will add a {@Link VNFCInstance} into a NetworkServiceRecord to a specific VirtualNetworkFunctionRecord. The VirtualDeploymentUnit is randomly chosen
     *
     * @param id
     * @param idVnf
     * @param component
     * @throws NotFoundException
     * @throws BadFormatException
     * @throws WrongStatusException
     */
    void addVNFCInstance(String id, String idVnf, VNFComponent component) throws NotFoundException, BadFormatException, WrongStatusException;

    /**
     * This method will remove a {@Link VNFCInstance} of a NetworkServiceRecord from a specific VirtualNetworkFunctionRecord. VirtualDeploymentUnit will be randomly chosen.
     *
     * @param id
     * @param idVnf
     */
    void deleteVNFCInstance(String id, String idVnf) throws NotFoundException, WrongStatusException, InterruptedException, ExecutionException, VimException;

    /**
     * This method will remove a {@Link VNFCInstance} of a NetworkServiceRecord from a specific VirtualDeploymentUnit of a specific VirtualNetworkFunctionRecord.
     *
     * @param id
     * @param idVnf
     * @param idVdu
     * @param idVNFCI
     */
    void deleteVNFCInstance(String id, String idVnf, String idVdu, String idVNFCI) throws NotFoundException, WrongStatusException, InterruptedException, ExecutionException, VimException;
}

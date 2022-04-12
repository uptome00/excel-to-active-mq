package th.co.magicsoftware.exceltoactivemq.service;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.magicsoftware.exceltoactivemq.model.*;
import th.co.magicsoftware.exceltoactivemq.repository.ExcelRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class ExcelService {


    private ExcelRepository excelRepository;

    public ExcelService(){

    }

    public ExcelService(String path) throws IOException {
        this.excelRepository = new ExcelRepository(path);
    }

    public int getNumberOfSheets() {
        return excelRepository.getWorkbook().getNumberOfSheets();
    }



    public int getLastRowNumber(String sheetName){
        int sheetIndex = excelRepository.getSheetIndexBySheetName(sheetName);
        XSSFSheet sheet = excelRepository.getSheetBySheetIndex(sheetIndex);
        return sheet.getLastRowNum();
    }

    public Map<String , Object> mapData(String sheetName,int requestIndex, int headerIndex, int dataIndex) {
        int sheetIndex = excelRepository.getSheetIndexBySheetName(sheetName);
        XSSFSheet sheet = excelRepository.getSheetBySheetIndex(sheetIndex);
        Map<String, Object> transaction = getData(sheet,requestIndex,headerIndex,dataIndex);
        Map<String, Object> map = new HashMap<>();
        map.put("transactionSchema",transaction);
        return transaction;
    }

    public Map getData(XSSFSheet sheet,int requestIndex, int headerIndex, int dataIndex){

        List<String> headers = new ArrayList<>();
        List<Object> dataHeader = new ArrayList<>();
        List<String> body = new ArrayList<>();
        List<Object> dataBody = new ArrayList<>();
        UserSchema user = new UserSchema();
        BranchSchema branch = new BranchSchema();
        TransactionTypeSchema transactionType = new TransactionTypeSchema();
        ResponseStatusSchema responseStatus = new ResponseStatusSchema();
        AccountSchema account = new AccountSchema();
        CustomerSchema customer = new CustomerSchema();
        AccountSchema destinationAccount = new AccountSchema();
        CustomerSchema destinationCustomer = new CustomerSchema();
        CompanySchema company = new CompanySchema();
        LimitAmountSchema limitAmount = new LimitAmountSchema();
        AccountProductSchema accountProduct = new AccountProductSchema();
        AccountProductSchema destinationAccountProduct = new AccountProductSchema();
        FinancialInstitutionSchema accountFinanciailInstitution = new FinancialInstitutionSchema();
        FinancialInstitutionSchema destinationAccountFinanciailInstitution = new FinancialInstitutionSchema();

        IntStream.rangeClosed(1,sheet.getRow(dataIndex).getLastCellNum()).forEach(round -> {
            String request = String.valueOf(sheet.getRow(requestIndex).getCell(round));
            String header = String.valueOf(sheet.getRow(headerIndex).getCell(round));
            Object value = sheet.getRow(dataIndex).getCell(round);

            switch (request){
                case "requestHeader" :
                    switch(header) {
                        case "user-name":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                user.setName(value.toString());
                            }
                            break;
                        case "user-typeCode":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                user.setTypeCode(value.toString());
                            }
                            break;
                        case "transactionType-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                transactionType.setCode(value.toString());
                            }
                            break;
                        case "transactionType-description":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                transactionType.setDescription(value.toString());
                            }
                            break;
                        case "transactionType-drCr":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                transactionType.setDrCr(value.toString());
                            }
                            break;
                        case "responseStatus-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                responseStatus.setCode(value.toString());
                            }
                            break;
                        case "responseStatus-description":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                responseStatus.setDescription(value.toString());
                            }
                            break;
                        default:
                            headers.add(header);
                            if(value != null) {
                                dataHeader.add(value.toString());
                            } else {
                                dataHeader.add(null);
                            }
                            break;
                    }
                    break;
                case "requestBody" :
                    switch(header) {
                        case "account-accountNumber":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                account.setAccountNumber(value.toString());
                            }
                            break;
                        case "account-accountName":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                account.setAccountName(value.toString());
                            }
                            break;
                        case "account-accountProduct-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                accountProduct.setCode(value.toString());
                            }
                            break;
                        case "account-accountProduct-description":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                accountProduct.setDescription(value.toString());
                            }
                            break;
                        case "account-finantailInstitution-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                accountFinanciailInstitution.setCode(value.toString());
                            }
                            break;
                        case "account-finantailInstitution-name":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                accountFinanciailInstitution.setName(value.toString());
                            }
                            break;
                        case "customer-customerNumber":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                customer.setCustomerNumber(value.toString());
                            }
                            break;
                        case "customer-fullName":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                customer.setFullName(value.toString());
                            }
                            break;
                        case "destinationAccount-accountNumber":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationAccount.setAccountNumber(value.toString());
                            }
                            break;
                        case "destinationAccount-accountName":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationAccount.setAccountName(value.toString());
                            }
                            break;
                        case "destinationAccount-accountProduct-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationAccountProduct.setCode(value.toString());
                            }
                            break;
                        case "destinationAccount-accountProduct-description":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationAccountProduct.setDescription(value.toString());
                            }
                            break;
                        case "destinationAccount-finantailInstitution-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationAccountFinanciailInstitution.setCode(value.toString());
                            }
                            break;
                        case "destinationAccount-finantailInstitution-name":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationAccountFinanciailInstitution.setName(value.toString());
                            }
                            break;
                        case "destinationCustomer-customerNumber":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationCustomer.setCustomerNumber(value.toString());
                            }
                            break;
                        case "destinationCustomer-fullName":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                destinationCustomer.setFullName(value.toString());
                            }
                            break;
                        case "company-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                company.setCode(value.toString());
                            }
                            break;
                        case "company-name":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                company.setName(value.toString());
                            }
                            break;
                        case "limitAmount-transactionCategoryCode":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                limitAmount.setTransactionCategoryCode(value.toString());
                            }
                            break;
                        case "limitAmount-limitAmount":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                limitAmount.setLimitAmount(new BigDecimal( value.toString() ));
                            }
                            break;
                        case "branch-code":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                branch.setCode(value.toString());
                            }
                            break;
                        case "branch-name":
                            if (value == null) {
                                break;
                            } else if(value.toString().isBlank() || value.toString().isEmpty()){
                                break;
                            } else {
                                branch.setName(value.toString());
                            }
                            break;
                        default:
                            body.add(header);
                            if(value != null) {
                                dataBody.add(value.toString());
                            } else {
                                dataBody.add(null);
                            }
                            break;
                    }
                    break;
                default:
                    break;
            }
        });

        // Check Object of Header before put to map
        if(user.getName() == null && user.getTypeCode() != null){
            throw new NullPointerException("user-name cannot be null if you want to use User. ");
        }else if(user.getName() != null){
            headers.add("user");
            dataHeader.add(user);
        }

        if((transactionType.getCode() == null || transactionType.getDrCr() == null ) && transactionType.getDescription() != null ){
            throw new NullPointerException("transactionType-code and transactionType-drCr cannot be null. ");
        } else if(transactionType.getCode() != null){
            headers.add("transactionType");
            dataHeader.add(transactionType);
        }

        if(responseStatus.getCode() == null && responseStatus.getDescription() != null ){
            throw new NullPointerException("responseStatus-code cannot be null. ");
        } else if(responseStatus.getCode() != null){
            headers.add("responseStatus");
            dataHeader.add(responseStatus);
        }

        // Check Sub Object of Body before put to Main Object

        if(accountProduct.getCode() == null && accountProduct.getDescription() != null ){
            throw new NullPointerException("account-accountProduct-code cannot be null. ");
        } else if(accountProduct.getCode() != null){
            account.setAccountProduct(accountProduct);
        } else {
            account.setAccountProduct(null);
        }

        if(accountFinanciailInstitution.getCode() == null && accountProduct.getDescription() != null ){
            throw new NullPointerException("account-finantailInstitution-code cannot be null. ");
        } else if(accountFinanciailInstitution.getCode() != null){
            account.setFinancialInstitution(accountFinanciailInstitution);
        }

        if(destinationAccountProduct.getCode() == null && destinationAccountProduct.getDescription() != null ){
            throw new NullPointerException("destinationAccount-accountProduct-code cannot be null. ");
        } else if(destinationAccountProduct.getCode() != null){
            destinationAccount.setAccountProduct(destinationAccountProduct);
        } else {
            destinationAccount.setAccountProduct(null);
        }

        if(destinationAccountFinanciailInstitution.getCode() == null && destinationAccountFinanciailInstitution.getName() != null ){
            throw new NullPointerException("destinationAccount-finantailInstitution-code cannot be null. ");
        } else if(destinationAccountFinanciailInstitution.getCode() != null) {
            destinationAccount.setFinancialInstitution(destinationAccountFinanciailInstitution);
        }


        // Check Object of Body before put to map

        if((account.getAccountNumber() == null || account.getFinancialInstitution().getCode() == null) && account.getAccountName() != null ){
            throw new NullPointerException("account-accountNumber and account-finantailInstitution-code cannot be null if you want to use Account. ");
        }else if(account.getAccountNumber() != null){
            body.add("account");
            dataBody.add(account);
        }

        if((customer.getCustomerNumber() == null ) && customer.getFullName() != null){
            throw new NullPointerException("customer-customerNumber cannot be null if you want to use Customer. ");
        }else if(customer.getCustomerNumber() != null){
            body.add("customer");
            dataBody.add(customer);
        }

        if((destinationAccount.getAccountNumber() == null || destinationAccount.getFinancialInstitution().getCode() == null) && destinationAccount.getAccountName() != null ){
            throw new NullPointerException("destinationAccount-accountNumber and destinationAccount-finantailInstitution-code cannot be null if you want to use Account. ");
        }else if(destinationAccount.getAccountNumber() != null){
            body.add("destinationAccount");
            dataBody.add(destinationAccount);
        }

        if((destinationCustomer.getCustomerNumber() == null ) && destinationCustomer.getFullName() != null){
            throw new NullPointerException("destinationCustomer-customerNumber cannot be null if you want to use Customer. ");
        }else if(destinationCustomer.getCustomerNumber() != null){
            body.add("destinationCustomer");
            dataBody.add(destinationCustomer);
        }

        if((company.getCode() == null ) && company.getName() != null){
            throw new NullPointerException("company-code cannot be null if you want to use Company. ");
        }else if(company.getCode() != null){
            body.add("company");
            dataBody.add(company);
        }

        if((limitAmount.getTransactionCategoryCode() == null || limitAmount.getLimitAmount() == null) && limitAmount.getLimitAmount() != null){
            throw new NullPointerException("limitAmount-transactionCategoryCode and limitAmount-limitAmount cannot be null if you want to use LimitAmount. ");
        }else if(limitAmount.getTransactionCategoryCode() != null){
            body.add("limitAmount");
            dataBody.add(limitAmount);
        }

        if(branch.getCode() == null && branch.getName() != null){
            throw new NullPointerException("branch-code cannot be null if you want to use Branch. ");
        }else if(branch.getCode() != null){
            body.add("branch");
            dataBody.add(branch);
        }


        Map<String, Object> mapHeader = (Map<String, Object>) toMap(headers,dataHeader);
        Map<String, Object> mapBody = (Map<String, Object>) toMap(body,dataBody );
        Map<String, Object> map = new HashMap<>();
        map.put("requestHeader",mapHeader);
        map.put("requestBody",mapBody);
        return map;
    }

    public  Map<?, ?> toMap(List<?> keys, List<?> values) {
        Map<String,Object> map = new HashMap<>();
        IntStream.range(0, keys.size()).forEach(round -> {
            map.put(keys.get(round).toString(),values.get(round));
        });
//        IntStream.range(0, keys.size()).boxed().collect(Collectors.toMap(keys::get, values::get));
        return map;
    }

    public List<Integer> getCaseNumberLenght(String sheetName, String caseNumber) {
        int sheetIndex = excelRepository.getSheetIndexBySheetName(sheetName);
        XSSFSheet sheet = excelRepository.getSheetBySheetIndex(sheetIndex);
        AtomicReference<Boolean> flag = new AtomicReference<>(false);
        List<Integer> caseNumStartEnd = new ArrayList<>();
        int lastRow = sheet.getLastRowNum()+1;
        IntStream.rangeClosed(1, lastRow)
                .forEach(rowNum -> {
                    if(sheet.getRow(rowNum) == null || sheet.getRow(rowNum).getCell(0) == null){
                        caseNumStartEnd.add(rowNum-1);
                        flag.set(false);
                        return;
                    } else if(sheet.getRow(rowNum).getCell(0).toString().equals(caseNumber) && !flag.get()){
                        caseNumStartEnd.add(rowNum);
                        flag.set(true);
                    } else if (!sheet.getRow(rowNum).getCell(0).toString().equals(caseNumber) && flag.get()){
                        caseNumStartEnd.add(rowNum-1);
                        flag.set(false);
                    }
                });
        return caseNumStartEnd;
    }
}

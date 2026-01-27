```java

public ResponseEntity<Resource> downloadAgentReport(Long fromDate, Long toDate, List<Long> agentIds, Boolean isMeasuredAt) throws FileNotFoundException {
        Date from = fromDate != null ? DateTimeUtil.getStartOfDay(new Date(fromDate)) : DateTimeUtil.getMonthStartDate(new Date());
        Date to = toDate != null ? DateTimeUtil.getEndOfDay(new Date(toDate)) : DateTimeUtil.getEndOfDay(new Date());

        Set<Agent> companies = agentIds.stream().map(appBeanUtil::getCompanyAgentById).collect(Collectors.toSet());
        Set<Long> allCompanyIds = new HashSet<>();
        Set<Long> allAgentUserIds = new HashSet<>();
        Set<Long> inAllTimeEmployeesUserIds = new HashSet<>();
        Set<Long> employeesUserIds = new HashSet<>();
        Set<String> companyAbsolutePath = new HashSet<>();

        companies.forEach(it -> {
        allAgentUserIds.add(it.getId());
        allCompanyIds.addAll(appBeanUtil.findAgentUserIdsInPath(it));
        inAllTimeEmployeesUserIds.addAll(employeeRepository.findEmployeeUserIdsForAttachedAndDetachedByCompanyIds(
        Collections.singletonList(it.getId()), new Date(0), to
        ));
        employeesUserIds.addAll(employeeRepository.findEmployeeWithoutDetachedByCompanyIds(
        Collections.singletonList(it.getId()), new Date(0), to
        ));
        companyAbsolutePath.addAll(aggregatorAgentStatsRepository.getAgentPaths(it.getAbsolutePath()));
        });

        List<DHCAgentPerformanceStats> reportData;
        if (isMeasuredAt) {
        reportData = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//            try {
//                Future<List<DHCAgentPerformanceStats>> futureNoOfOtherServices = executorService.submit(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfOtherServices(from, to, companyAbsolutePath, allCompanyIds, allAgentUserIds, inAllTimeEmployeesUserIds, employeesUserIds));
//                Future<List<DHCAgentPerformanceStats>> futureNoOfService = executorService.submit(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfService(from, to, companyAbsolutePath));
//                Future<List<DHCAgentPerformanceStats>> futureNoOfUserServed = executorService.submit(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfUsersServed(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds));
//                Future<List<DHCAgentPerformanceStats>> futureNoOfMeasurements = executorService.submit(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfTotalMeasurement(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds));
//
//                reportData.addAll(futureNoOfOtherServices.get());
//                reportData.addAll(futureNoOfService.get());
//                reportData.addAll(futureNoOfUserServed.get());
//                reportData.addAll(futureNoOfMeasurements.get());
//
//            } catch (Exception e) {
//                log.error("Error while getting agent performance report data", e);
//            } finally {
//                executorService.shutdown();
//            }

        try {
        reportData = this.aggregatorAgentStatsRepository.getCorporateAgentPerformance(from, to, companyAbsolutePath, allCompanyIds, allAgentUserIds, inAllTimeEmployeesUserIds, employeesUserIds);
        } catch (Exception e) {
        log.error("Error while getting agent performance report data", e);
        } finally {
        executorService.shutdown();
        }

//            List<DHCAgentPerformanceStats> reportNoOfOtherServices;
//            List<DHCAgentPerformanceStats> reportNoOfServices;
//            List<DHCAgentPerformanceStats> reportNoOfUserServed;
//            List<DHCAgentPerformanceStats> reportNoOfMeasurements;
//            CompletableFuture<List<DHCAgentPerformanceStats>> futureNoOfOtherServices = CompletableFuture.supplyAsync(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfOtherServices(from, to, companyAbsolutePath, allCompanyIds, allAgentUserIds, inAllTimeEmployeesUserIds, employeesUserIds));
//            CompletableFuture<List<DHCAgentPerformanceStats>> futureNoOfService = CompletableFuture.supplyAsync(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfService(from, to, companyAbsolutePath));
//            CompletableFuture<List<DHCAgentPerformanceStats>> futureNoOfUserServed = CompletableFuture.supplyAsync(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfUsersServed(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds));
//            CompletableFuture<List<DHCAgentPerformanceStats>> futureNoOfMeasurements = CompletableFuture.supplyAsync(() -> this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfTotalMeasurement(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds));
//            CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureNoOfMeasurements, futureNoOfOtherServices, futureNoOfService, futureNoOfUserServed);
//
//            allFutures.thenRun(() -> {
//                try {
//                    reportData.addAll(futureNoOfOtherServices.get());
//                    reportData.addAll(futureNoOfService.get());
//                    reportData.addAll(futureNoOfUserServed.get());
//                    reportData.addAll(futureNoOfMeasurements.get());
//                } catch (Exception e) {
//                    log.error("Error while getting agent performance report data", e);
//                }
//            });
//            reportNoOfOtherServices = this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfOtherServices(from, to, companyAbsolutePath, allCompanyIds, allAgentUserIds, inAllTimeEmployeesUserIds, employeesUserIds);
//            reportNoOfServices = this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfService(from, to, companyAbsolutePath);
//            reportNoOfUserServed = this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfUsersServed(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds);
//            reportNoOfMeasurements = this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfTotalMeasurement(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds);
//            reportData.addAll(this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfOtherServices(from, to, companyAbsolutePath, allCompanyIds, allAgentUserIds, inAllTimeEmployeesUserIds, employeesUserIds));
//            reportData.addAll(this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfService(from, to, companyAbsolutePath));
//            reportData.addAll(this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfUsersServed(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds));
//            reportData.addAll(this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceNoOfTotalMeasurement(from, to, companyAbsolutePath, inAllTimeEmployeesUserIds));
        } else {
        reportData = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
        reportData = this.aggregatorAgentStatsRepository.getCorporateAgentPerformanceWithCreatedMeasuredDate(from, to, companyAbsolutePath, allCompanyIds, allAgentUserIds, inAllTimeEmployeesUserIds, employeesUserIds);
        } catch (Exception e) {
        log.error("Error while getting agent performance report data", e);
        } finally {
        executorService.shutdown();
        }
        }

```
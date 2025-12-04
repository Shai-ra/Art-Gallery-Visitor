public class EliteVisitor extends ArtGalleryVisitor
{
    private boolean assignedPersonalArtAdvisor;
    private boolean exclusiveEventAccess;

    // Constructor
    public EliteVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
        this.assignedPersonalArtAdvisor = false;
        this.exclusiveEventAccess = false;
    }

    // Accessors
    public boolean getAssignedPersonalArtAdvisor() {
        return assignedPersonalArtAdvisor;
    }

    public boolean getExclusiveEventAccess() {
        return exclusiveEventAccess;
    }

    
    //checks rewards points and assigns a personal art advisor
    public boolean assignPersonalArtAdvisor() {
        if (rewardPoints > 5000){
            assignedPersonalArtAdvisor = true;
        }
        return assignedPersonalArtAdvisor;
    }

    //checks PersonalArtAdvisor and grants exclusiveEventAccess
    public boolean exclusiveEventAccess() {
        if (assignedPersonalArtAdvisor){
            exclusiveEventAccess = true;
        }
        return exclusiveEventAccess;
    }

    
    @Override
    public String buyProduct(String artworkName, double artworkPrice) {
        if (!isActive){
            return "Inactive visitor. Log visit first.";
        }else{
            //artwork is not bought or artwork is null or doesn't match the new artworkName
            if (!isBought || (this.artworkName==null) || !this.artworkName.equals(artworkName)) {
            this.artworkName = artworkName;
            this.artworkPrice = artworkPrice;
            this.isBought = true;
            buyCount++;
            return "Elite purchase successful.";
        } else {
            return "Same artwork already purchased.";
        }
        }
        
    }

    @Override
    public double calculateDiscount() {
        if (!isBought){
            return 0;
        }else{
            discountAmount = artworkPrice * 0.40;
            finalPrice = artworkPrice - discountAmount;
            return discountAmount;
        }
    }

    
    @Override
    public double calculateRewardPoint() {
        if (!isBought) return rewardPoints;
        rewardPoints += finalPrice * 10;
        return rewardPoints;
    }
    
    //Bill output
    @Override
    public void generateBill() {
        if (isBought) {
            System.out.println("          === BILL ===");
            System.out.println("|Visitor ID     |" + visitorId);
            System.out.println("|Visitor Name   |" + fullName);
            System.out.println("|Artwork Name   |" + artworkName);
            System.out.println("|Artwork Price  |" + artworkPrice);
            System.out.println("|Discount Amount|" + discountAmount);
            System.out.println("|Final Price    |" + finalPrice);
        } else {
            System.out.println("No purchase has been made to generate a bill.");
        }
    }
    
    //Terminate Visitor
    private void terminateVisitor() {
        isActive = false;
        assignedPersonalArtAdvisor = false;
        exclusiveEventAccess = false;
        visitCount = 0;
        cancelCount = 0;
        rewardPoints = 0;
    }

    // cancelProduct implementation
    @Override
    public String cancelProduct(String artworkName, String cancellationReason) {
        if (cancelCount >= cancelLimit) {
            terminateVisitor();
            return "Cancellation limit reached. Visitor account terminated.";
        }
        if (buyCount == 0) {
            return "No product has been bought to cancel.";
        }
        if (this.artworkName.equals(artworkName)){
            
            //Additional code
            // Store artwork name before clearing it
            String cancelledArtwork = this.artworkName;

            this.artworkName = null;
            this.isBought = false;
            refundableAmount = artworkPrice - (artworkPrice * 0.05);
            rewardPoints -= finalPrice * 10;
            cancelCount++;
            buyCount--;
            
            this.cancellationReason = cancellationReason;
            return "Product cancelled. Refundable amount: " + refundableAmount;
        }
        else {
            return "Incorrect artwork name. Cancellation failed.";
    }
}
    

    @Override
    public void display() {
        super.display();
        System.out.println("Assigned Advisor: " + assignedPersonalArtAdvisor);
        System.out.println("Exclusive Event Access: " + exclusiveEventAccess);
    }
}

